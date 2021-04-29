using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo.Services
{
    public interface IGrupoEtapaService : IDisposable
    {
        int InserirGrupoEtapa(GrupoEtapa grupo);

        void AlterarGrupoEtapa(GrupoEtapa grupo);

        void DeletarGrupoEtapa(int id);

        GrupoEtapa ConsultarPorId(int id);

        List<GrupoEtapa> ListarGrupoEtapa();
    }
}
