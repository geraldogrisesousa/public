using BA.Grisecorp.App.API.Domain.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa.Repository
{
    public interface IEtapaRepository : IRepository<Etapa>
    {
        IEnumerable<Etapa> ListarEtapasPorGrupo(int codigoGrupo);
    }
}
