import BaseService from './core/BaseService';

class GrupoEtapaService extends BaseService {
  InserirGrupoEtapa = async (grupo) => {
    const action = 'InserirGrupoEtapa';
    const response = await this.Insert(grupo, action);
    return response.data;
  };

  AlterarGrupoEtapa = async (grupo) => {
    await this.Update(grupo, 'AlterarGrupoEtapa');
  };

  DeletarGrupoEtapa = async (id) => {
    await this.Delete(id, 'DeletarGrupoEtapa');
  };

  DetalharGrupoEtapa = async (id) => {
    const response = await this.GetById(id, 'DetalharGrupoEtapa');
    return response.data;
  };

  ListarGrupoEtapa = async () => {
    const response = await this.GetAllPost('ListarGrupoEtapas');
    return response.data;
  };
}

export default new GrupoEtapaService();
