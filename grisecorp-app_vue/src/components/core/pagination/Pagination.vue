<template>
    <nav aria-label="PageGridview">
         <ul class="pagination">
             <li class="page-item" v-bind:class="disabledPage(currentPage,'P')">
                <a v-on:click.prevent.stop="onPrevious(currentPage)" class="page-link">Previous</a>
             </li>
              <li class="page-item"
                 v-for="p in pages"
                 v-bind:key="'page'+p.value"
                 v-bind:class="activePage(p.value) + ' ' + visible(p)">
                <a v-on:click.prevent.stop="onPage(p.value)" class="page-link">{{p.value}}</a>
             </li>
             <li class="page-item" v-bind:class="disabledPage(currentPage,'N')">
                <a v-on:click.prevent.stop="onNext(currentPage)" class="page-link">Next</a>
             </li>
        </ul>
    </nav>
</template>
<script>
import Page from './Page';

export default {
  name: 'Pagination',
  props: {
    totalRecords: Number,
    perPage: Number,
    page: Number,
  },
  watch: {
    totalRecords(newValue) {
      this.setPageSettings(this.page);
      this.currentPage = this.page;
    },
  },
  data() {
    return {
      currentPage: 0,
      pages: [],
      pageShow: 6,
    };
  },
  methods: {
    onPage(page) {
      this.currentPage = page;
      this.setPageSettings(page);
    },
    onNext(page) {
      page += 1;
      this.currentPage = page;
      this.setPageSettings(page);
    },
    onPrevious(page) {
      page -= 1;
      this.currentPage = page;
      this.setPageSettings(page);
    },
    activePage(page) {
      let active = false;
      if (page === this.currentPage) {
        active = true;
      }

      return active ? 'active' : '';
    },
    visible(page) {
      return !page.visible ? 'hidden' : '';
    },
    disabledPage(page, type) {
      let disabled = false;
      if (page === 1 && type === 'P') {
        disabled = true;
      } else if (page === this.pages.length && type === 'N') {
        disabled = true;
      }

      return disabled ? 'disabled' : '';
    },
    setPageSettings(page) {
      const aux = this.totalRecords % this.perPage;
      let countPages = Math.floor(this.totalRecords / this.perPage);
      if (aux !== 0) {
        countPages += 1;
      }
      this.showPages(countPages);
      this.$emit('emit-page', page);
    },
    showPages(countPages) {
      const pageArray = [];
      let count = 1;
      for (let i = 0; i < countPages; i++) {
        let show = false;
        if (count < this.currentPage + this.pageShow) {
          show = true;
        }
        pageArray.push(new Page(count, show));
        count += 1;
      }
      this.pages = pageArray;
    },
  },
};
</script>
