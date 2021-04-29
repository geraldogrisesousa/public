using BA.Grisecorp.App.API.Application.ViewModels;
using System;
using System.Collections.Generic;

namespace BA.Grisecorp.App.API.Application.Interfaces
{
    public interface IEtapaAppService : IDisposable
    {
        void InserirEtapa(EtapaModel etapa);

        void AlterarEtapa(EtapaModel etapa);

        void DeletarEtapa(int id);

        EtapaModel ConsultarPorId(int id);

        List<EtapaModel> ListaEtapas();

        List<EtapaModel> ListaEtapaPorGrupo(int grupo);
    }
}
