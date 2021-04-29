using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa;
using BA.Grisecorp.App.Infra.Data.Core;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace BA.Grisecorp.App.Infra.Data.Mappings
{
    public class EtapaMap : MappingCore<Etapa>
    {
        public override void Map(EntityTypeBuilder<Etapa> builder)
        {
            builder.ToTable("T250ETAP");
            builder.HasKey(x => x.Sequencial);

            builder.Property(x => x.Sequencial).HasColumnName(@"SQ_ETP").IsRequired().HasColumnType("int");
            builder.Property(x => x.CodigoGrupoEtapa).HasColumnName(@"CD_GP_ETP").IsRequired().HasColumnType("int");
            builder.HasOne(x => x.GrupoEtapa).WithMany(y => y.ListaEtapa).HasForeignKey(x => x.CodigoGrupoEtapa);
            builder.Property(x => x.Descricao).HasColumnName(@"DE_ETP").IsRequired().IsUnicode(false).HasColumnType("varchar").HasMaxLength(300);
            builder.Property(x => x.Nome).HasColumnName(@"NM_ETP").IsRequired().IsUnicode(false).HasColumnType("varchar").HasMaxLength(40);
            builder.Property(x => x.NumeroPosicao).HasColumnName(@"NR_POS_ETP").IsRequired().HasColumnType("int");
            builder.Property(x => x.QuantidadeEntrega).HasColumnName(@"QT_ENT").HasColumnType("int");
            builder.Property(x => x.DuracaoEntregaMeses).HasColumnName(@"QT_DR_MES_ENT").IsRequired().HasColumnType("int");
            builder.Property(x => x.DataCadastro).HasColumnName(@"DT_CAD").IsRequired().HasColumnType("datetime");
            builder.Property(x => x.UsuarioCadastro).HasColumnName(@"MT_USU_CAD").IsUnicode(false).HasColumnType("varchar").HasMaxLength(7);
            base.Map(builder);
        }
    }
}
