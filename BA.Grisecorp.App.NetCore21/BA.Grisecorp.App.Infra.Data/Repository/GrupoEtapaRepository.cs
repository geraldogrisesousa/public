using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo.Repository;
using BA.Grisecorp.App.Infra.Data.Context;
using BA.Grisecorp.App.Infra.Data.Core.Repository;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.Infra.Data.Repository
{
    public class GrupoEtapaRepository : Repository<GrupoEtapa>, IGrupoEtapaRepository
    {
        public GrupoEtapaRepository(DatabaseContext context) : base(context)
        {

        }
    }
}
