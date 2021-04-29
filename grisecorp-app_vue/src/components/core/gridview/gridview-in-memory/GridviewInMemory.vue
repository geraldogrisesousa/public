<template>
   <div>
      <table v-bind:id="id" class="table">
         <thead>
              <tr>
                 <th v-if="renderAction('left')"  class="ctr actions" scope="col">
                      <a v-on:click.prevent.stop="insertRow()">
                         <i class="fa fa-plus"></i>
                      </a>
                  </th>
                  <th v-for="header in headers" v-bind:key="header.columnTitle">
                      {{header.columnTitle}}
                 </th>
                  <th v-if="renderAction('right')"  class="ctr actions" scope="col">
                       <a v-on:click.prevent.stop="insertRow()">
                         <i class="fa fa-plus"></i>
                       </a>
                  </th>
             </tr>
         </thead>
          <tbody>
              <tr v-if="editting">
                  <td v-if="renderAction('left')" class="ctr actions">
                      <a v-on:click.prevent.stop="saveInline(row,-1)">
                         <i class="fa fa-save"></i>
                      </a>
                      <a v-on:click.prevent.stop="cancelInsert()">
                         <i class="fa fa-ban"></i>
                      </a>
                  </td>
                  <td v-for="header in headers" v-bind:key="header.columnTitle">
                      <input v-bind:disabled="header.disabled"
                              v-bind:name="header.columnName"
                              v-model="row[header.columnName]"
                              class="form-control"/>
                  </td>
                  <td v-if="renderAction('right')" class="ctr actions">
                      <a v-on:click.prevent.stop="saveInline(row,-1)">
                         <i class="fa fa-save"></i>
                      </a>
                      <a v-on:click.prevent.stop="cancelInsert()">
                         <i class="fa fa-ban"></i>
                      </a>
                  </td>
                 
              </tr>
              <tr v-bind:class="showLine(index)"
                  v-bind:key="dt[key.columnName]"
                  v-for="(dt, index) in data">
                   <td v-if="renderAction('left') && !dt.editting" class="ctr actions">
                        <a v-on:click.prevent.stop="editRow(dt,index)">
                           <i class="fa fa-pencil"></i>
                        </a>
                        <a v-on:click.prevent.stop="deleteInline(dt,index)">
                           <i class="fa fa-trash"></i>
                        </a>
                   </td>
                    <td v-if="renderAction('left') && dt.editting" class="ctr actions">
                        <a v-on:click.prevent.stop="saveInline(row,index)" v-if="row.editting">
                            <i class="fa fa-save"></i>
                        </a>
                        <a v-on:click.prevent.stop="cancelEdit(row,index)" v-if="row.editting">
                            <i class="fa fa-ban"></i>
                        </a>
                   </td>

                   <td v-for="header in headers" v-bind:key="header.columnTitle+1">
                      <span  v-if="!dt.editting">{{dt[header.columnName]}}</span>
                      <input v-if="dt.editting"
                             v-bind:disabled="header.disabled"
                             v-bind:name="header.columnName"
                             v-model="row[header.columnName]"
                             class="form-control"/>
                  </td>
                   <td v-if="renderAction('right') && !dt.editting" class="ctr actions">
                        <a v-on:click.prevent.stop="editRow(dt,index)">
                           <i class="fa fa-pencil"></i>
                        </a>
                        <a v-on:click.prevent.stop="deleteInline(dt,index)">
                           <i class="fa fa-trash"></i>
                        </a>
                   </td>
                    <td v-if="renderAction('right') && dt.editting" class="ctr actions">
                        <a v-on:click.prevent.stop="saveInline(row,index)" v-if="row.editting">
                            <i class="fa fa-save"></i>
                        </a>
                        <a v-on:click.prevent.stop="cancelEdit(row,index)" v-if="row.editting">
                            <i class="fa fa-ban"></i>
                        </a>
                   </td>
              </tr>
         </tbody>
      </table>
      <Pagination
          v-bind:page="page"
          v-bind:perPage="perPage"
          v-bind:totalRecords="total"
          v-on:emit-page="changePage"
       />
   </div>
</template>

<script>
import ObjectUtil from '../../../../services/core/util/ObjectUtil';
import Pagination from '../../pagination/Pagination.vue';

export default {
  name: 'GridviewInMemory',
  components: {
    Pagination,
  },
  props: {
    id: String,
    type: String,
    actionPosition: String,
    pagination: Boolean,
    perPage: Number,
    settings: Object,
  },
  data() {
    return {
      headers: [],
      data: [],
      page: 1,
      total: 0,
      key: '',
      row: {},
      rowBeforeEdit: {},
      editting: false,
    };
  },
  created() {
  },
  watch: {
    settings(value) {
      this.data = ObjectUtil.Convert(value.data);
      this.total = value.data.length;
      this.headers = ObjectUtil.Convert(value.headers);
      this.key = this.headers.find((x) => x.key);
      this.row = this.initRow();
    },
  },
  methods: {
    showLine(index) {
      let hiddenClass = '';
      if (this.perPage !== undefined) {
        const min = index >= (this.page - 1) * this.perPage;
        const max = index < this.page * this.perPage;
        hiddenClass = !(min && max) ? 'hidden' : '';
      }
      return hiddenClass;
    },
    renderAction(act) {
      return this.actionPosition.toLowerCase() === act;
    },
    changePage(current) {
      this.page = current;
    },
    initRow() {
      const newRow = {};
      this.headers.forEach((header) => {
        newRow[header.columnName] = '';
      });
      this.row = newRow;
    },
    insertRow() {
      this.editting = true;
      this.initRow();
    },
    cancelInsert() {
      this.editting = false;
    },
    editRow(row, index) {
      this.rowBeforeEdit = ObjectUtil.Convert(row);
      row.editting = true;
      this.data.splice(index, 1, row);
      this.row = ObjectUtil.Convert(row);
    },
    cancelEdit(rw, index) {
      this.rowBeforeEdit.editting = false;
      this.data.splice(index, 1, this.rowBeforeEdit);
    },
    deleteInline(row, index) {
        this.data.splice(index,1)
    },
    saveInline(row, index) {
      if (index === -1) {
        if(this.key){
            row[this.key.columnName] = this.data.length+1;
            this.data.push(row);
        }
        this.cancelInsert();
      } else {
        row.editting = false;
        this.data.splice(index,1,row);
      }
    },
  },

};
</script>
