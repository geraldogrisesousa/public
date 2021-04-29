import BaseService from './BaseService';
import ObjectUtil from './util/ObjectUtil';

class MockService extends BaseService {
    ListarGruposEtapas = async () => {
      const response = await this.GetAll('');
      return ObjectUtil.Convert(response);
    };

    ListarGruposEtapasTree = async () => {
      const response = await this.GetAll('');
      return ObjectUtil.Convert(response);
    };
}
export default new MockService();
