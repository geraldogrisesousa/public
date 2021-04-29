<template>
   <div>
      <table v-bind:id="id" class="table">
         <thead>
              <tr>
                  <th v-for="header in headers" v-bind:key="header.columnTitle">
                      {{header.columnTitle}}
                 </th>
             </tr>
         </thead>
          <tbody>
              <tr v-bind:class="showLine(index)"
                  v-bind:key="dt[key.columnName]"
                  v-for="(dt, index) in data">
                   <td v-for="header in headers" v-bind:key="header.columnTitle+1">
                      <span>{{dt[header.columnName]}}</span>
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
  name: 'SimpleGridview',
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
    changePage(current) {
      this.page = current;
    },
  },

};
</script>
