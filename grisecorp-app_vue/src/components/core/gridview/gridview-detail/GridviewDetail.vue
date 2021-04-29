<template>
   <div>
      <table v-bind:id="id" class="table">
         <thead>
              <tr>
                  <th v-if="renderAction('left')"  class="ctr actions" scope="col">
                      <a v-for="action in headerActions" v-bind:key="action.icon"  v-bind:href="action.url">
                         <i class="fa" v-bind:class="'fa-'+action.icon"></i>
                      </a>
                  </th>
                  <th v-for="header in headers" v-bind:key="header.columnTitle">
                      {{header.columnTitle}}
                 </th>
                 <th v-if="renderAction('right')"  class="ctr actions" scope="col">
                      <a v-for="action in headerActions" v-bind:key="action.icon"  v-bind:href="action.url">
                         <i class="fa" v-bind:class="'fa-'+action.icon"></i>
                      </a>
                  </th>
             </tr>
         </thead>
          <tbody>
              
              <tr v-bind:class="showLine(index)"
                  v-bind:key="dt[key.columnName]"
                  v-for="(dt, index) in data">
                   <td v-if="renderAction('left')"  class="ctr actions" scope="col">
                      <a v-for="action in rowActions" v-bind:key="action.icon"  v-bind:href="action.url">
                         <i class="fa" v-bind:class="'fa-'+action.icon"></i>
                      </a>
                      <a v-on:click.prevent.stop="deleteInline(dt,index)">
                         <i class="fa fa-trash"></i>
                      </a>
                   </td>
                   <td v-for="header in headers" v-bind:key="header.columnTitle+1">
                      <span>{{dt[header.columnName]}}</span>
                  </td>
                   <td v-if="renderAction('right')"  class="ctr actions" scope="col">
                      <a v-for="action in rowActions" v-bind:key="action.icon"  v-bind:href="action.url">
                         <i class="fa" v-bind:class="'fa-'+action.icon"></i>
                      </a>
                      <a v-on:click.prevent.stop="deleteInline(dt,index)">
                         <i class="fa fa-trash"></i>
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
  name: 'GridviewDetail',
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
      actions:[],
      headerActions:[],
      rowActions:[],
      headers: [],
      data: [],
      page: 1,
      total: 0,
      key: '',
    };
  },
  created() {
  },
  watch: {
    settings(value) {
      this.actions = ObjectUtil.Convert(value.actions);
      this.headerActions = this.actions.filter(x=> x.type === "header");
      this.rowActions = this.actions.filter(x=> x.type === "row");
      this.headers = ObjectUtil.Convert(value.headers);
      this.key = this.headers.find((x) => x.key);
      this.data = ObjectUtil.Convert(value.data);
      this.total = value.data.length;
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
    deleteInline(row) {
      console.log(row);
    },
   },

};
</script>
