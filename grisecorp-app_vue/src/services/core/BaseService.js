import Api from './Api';
import ObjectUtil from './util/ObjectUtil';

export default class BaseService {
    config = {
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        Accept: 'application/json',
      },
    };

    configData = {
      headers: {
        'Content-Type': 'multipart/form-data',
        'Access-Control-Allow-Origin': '*',
      },
    };

    Insert = async (model, action) => new Promise((resolve, reject) => {
      Api.post(action, JSON.stringify(model), this.config)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          resolve(ObjectUtil.Convert(error.data));
        });
    });

    Update = async (model, action) => this.PostModel(model, action);

    Delete = async (id, action) => this.PostId(id, action);

    DeleteModel = async (model, action) => this.PostModel(model, action);

    FindById = async (id, action) => this.PostId(id, action);

    FindAll = async (model, action) => new Promise((resolve, reject) => {
      Api.post(action, model, this.config)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          if (error !== undefined) {
            resolve(ObjectUtil.Convert(error.data));
          }
        });
    });

    GetById = async (id, action) => new Promise((resolve, reject) => {
      Api.get(`${action}?id=${id}`, this.config)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          resolve(ObjectUtil.Convert(error.data));
        });
    });

    GetAllPost = async (action) => new Promise((resolve, reject) => {
      Api.post(action, this.config)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          resolve(ObjectUtil.Convert(error.data));
        });
    });

    GetAll = (action) => new Promise((resolve, reject) => {
      Api.get(action, this.config)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          if (error !== null && error !== undefined) {
            resolve(ObjectUtil.Convert(error.data));
          }
        });
    });

    Upload = async (data, action) => new Promise((resolve, reject) => {
      Api.post(action, data, this.configData)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          resolve(ObjectUtil.Convert(error.data));
        });
    });

    Download = async (id, action) => new Promise((resolve, reject) => {
      Api.post(action, id, {
        responseType: 'arraybuffer',
        headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*',
          Accept: 'application/octet-stream',
        },
      })
        .then((res) => {
          resolve(ObjectUtil.Convert(res));
        })
        .catch((error) => {
          resolve(ObjectUtil.Convert(error.data));
        });
    });

    PostModel = async (model, action) => new Promise((resolve, reject) => {
      Api.post(action, model, this.config)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          resolve(ObjectUtil.Convert(error.data));
        });
    });

    PostId = async (id, action) => new Promise((resolve, reject) => {
      Api.post(action, id, this.config)
        .then((res) => {
          resolve(ObjectUtil.Convert(res.data));
        })
        .catch((error) => {
          resolve(ObjectUtil.Convert(error.data));
        });
    });
}
