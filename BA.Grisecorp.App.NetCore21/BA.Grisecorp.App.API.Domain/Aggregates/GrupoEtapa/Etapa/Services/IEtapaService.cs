using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa.Services
{
    public interface IEtapaService : IDisposable
    {
        void InserirEtapa(Etapa etapa);

        void AlterarEtapa(Etapa etapa);

        void DeletarEtapa(int id);

        Etapa ConsultarPorId(int id);

        List<Etapa> ListarEtapas();

        List<Etapa> ListarEtapasPorGrupo(int codigoGrupo);
    }
}
