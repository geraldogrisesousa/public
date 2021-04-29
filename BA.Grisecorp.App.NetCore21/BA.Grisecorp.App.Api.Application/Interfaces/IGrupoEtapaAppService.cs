using BA.Grisecorp.App.API.Application.ViewModels;
using System;
using System.Collections.Generic;

namespace BA.Grisecorp.App.API.Application.Interfaces
{
    public interface IGrupoEtapaAppService : IDisposable
    {
        int InserirGrupoEtapa(GrupoEtapaModel grupo);

        void AlterarGrupoEtapa(GrupoEtapaModel grupo);

        void DeletarGrupoEtapa(int id);

        GrupoEtapaModel ConsultarPorId(int id);

        List<GrupoEtapaModel> ListaGrupoEtapa();

    }
}
