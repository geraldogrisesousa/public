using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa.Repository;
using BA.Grisecorp.App.Infra.Data.Context;
using BA.Grisecorp.App.Infra.Data.Core.Repository;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace BA.Grisecorp.App.Infra.Data.Repository
{
    public class EtapaRepository : Repository<Etapa>, IEtapaRepository
    {
        public EtapaRepository(DatabaseContext context) : base(context)
        {

        }
        public IEnumerable<Etapa> ListarEtapasPorGrupo(int codigoGrupo)
        {

            return _context.Etapas.Where(x => x.CodigoGrupoEtapa == codigoGrupo).AsNoTracking();
        }
    }
}
