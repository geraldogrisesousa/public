using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace BA.Grisecorp.App.Infra.Data.Core.Extensions
{
    public abstract class EntityTypeConfiguration<TEntity> where TEntity : class
    {
        public abstract void Map(EntityTypeBuilder<TEntity> builder);
    }
}
