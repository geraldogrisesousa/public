using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo.Repository;
using BA.Grisecorp.App.AspNetCore3.Infra.Data.Context;
using BA.Grisecorp.App.AspNetCore3.Infra.Data.Core.Repository;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.AspNetCore3.Infra.Data.Repository
{
    public class GrupoEtapaRepository : Repository<GrupoEtapa>, IGrupoEtapaRepository
    {
        public GrupoEtapaRepository(DatabaseContext context) : base(context)
        {

        }
    }
}
