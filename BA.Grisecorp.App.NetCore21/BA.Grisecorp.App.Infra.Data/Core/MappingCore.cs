using BA.Grisecorp.App.API.Domain.Aggregates.Model;
using BA.Grisecorp.App.Infra.Data.Core.Extensions;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.Infra.Data.Core
{
    public class MappingCore<T> : EntityTypeConfiguration<T> where T : EntityCore<T>
    {
        public override void Map(EntityTypeBuilder<T> builder)
        {
            builder.Ignore(x => x.CascadeMode);
            builder.Ignore(x => x.ValidationResult);
        }
    }

}
