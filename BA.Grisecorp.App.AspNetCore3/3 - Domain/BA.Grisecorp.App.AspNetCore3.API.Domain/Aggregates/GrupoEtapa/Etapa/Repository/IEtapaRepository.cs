using BA.Grisecorp.App.AspNetCore3.API.Domain.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa.Repository
{
    public interface IEtapaRepository : IRepository<Etapa>
    {
        IEnumerable<Etapa> ListarEtapasPorGrupo(int codigoGrupo);
    }
}
