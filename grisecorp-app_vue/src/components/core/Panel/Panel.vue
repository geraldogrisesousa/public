<template>
    <div class="card">
        <h5 class="card-header">
            <i  v-if="checkIconClass" class="fa" v-bind:class="getIconClass"></i>
            {{title}}
        </h5>
        <div class="card-body">
            <slot></slot>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Panel',
  props: ['title', 'icon'],
  computed: {
    getIconClass() {
      return this.icon != null ? `fa-${this.icon}` : '';
    },
    checkIconClass() {
      return this.icon != null;
    },

  },
  methods: {

  },

};
</script>
