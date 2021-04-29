import BaseService from './core/BaseService';

class EtapaService extends BaseService {
  InserirEtapa = async (etapa) => {
    await this.Insert(etapa, 'InserirEtapa');
  };

  AlterarEtapa = async (etapa) => {
    await this.Update(etapa, 'AlterarEtapa');
  };

  DeletarEtapa = async (id) => {
    await this.Delete(id, 'DeletarEtapa');
  };

  DetalharEtapa = async (id) => {
    const response = await this.GetById(id, 'DetalharEtapa');
    return response.data;
  };

  ListarEtapaPorGrupo = async (codigoGrupo) => {
    const response = await this.FindAll(codigoGrupo, 'ListarEtapasPorGrupo');
    return response.data;
  };
}

export default new EtapaService();
