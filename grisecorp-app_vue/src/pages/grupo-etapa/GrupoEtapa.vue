<template>
    <Panel v-bind:title="'Grupo Etapa'"  v-bind:icon="'windows'" >
         <h1>Grupo Etapa</h1>
          <GridviewDetail
              v-bind:id="'GrupoEtapa'"
              v-bind:actionPosition="'left'"
              v-bind:pagination="true"
              v-bind:perPage="5"
              v-bind:settings="settings"
          />

    </Panel>
</template>

<script>
import Panel from '../../components/core/Panel/Panel.vue';
import GridviewDetail from '../../components/core/gridview/gridview-detail/GridviewDetail.vue';
import MockService from '../../services/core/MockService';
import TableSettings from '../../components/core/gridview/settings/TableSettings';
import ObjectUtil from '../../services/core/util/ObjectUtil';

export default {
  name: 'GrupoEtapa',
  components: {
    Panel,
    GridviewDetail,
  },
  created() {
    this.getData();
  },
  data() {
    return {
      header: [
        {
          key: true,
          columnTitle: 'Código',
          columnName: 'sequencial',
          disabled: true,
          align: 'center',
        },
        {
          columnTitle: 'Nome',
          text: true,
          columnName: 'nomeGrupoEtapa',
        },
        {
          columnTitle: 'Descricao',
          columnName: 'descricaoGrupoEtapa',
          treeField: true,
        },
      ],
      actions: [
        {
          icon:"plus",
          type: 'header',
          url:"/home"
        },
        {
          icon:"pencil",
          type:'row',
          url:"/home"
        }
      ],
      dados: [],
      settings: new TableSettings(),
    };
  },
  methods: {
    getData() {
      MockService.ListarGruposEtapas().then((response) => {
        this.dados = ObjectUtil.Convert(response);
        this.defineSettings();
      }).finally(() => {
      });
    },
    defineSettings() {
      const settings = new TableSettings();
      settings.data = this.dados;
      settings.headers = ObjectUtil.Convert(this.header);
      settings.actions = ObjectUtil.Convert(this.actions);
      this.settings = settings;
    },
  },

};
</script>
