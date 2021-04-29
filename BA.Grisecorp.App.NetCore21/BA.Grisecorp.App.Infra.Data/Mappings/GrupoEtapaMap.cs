using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo;
using BA.Grisecorp.App.Infra.Data.Core;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.Infra.Data.Mappings
{
	public class GrupoEtapaMap : MappingCore<GrupoEtapa>
	{
		public override void Map(EntityTypeBuilder<GrupoEtapa> builder)
		{

			builder.ToTable("T250GRET");
			builder.HasKey(x => x.Sequencial);

			builder.Property(x => x.Sequencial).HasColumnName(@"SQ_GP_ETP").IsRequired().HasColumnType("int");
			builder.Property(x => x.NomeGrupoEtapa).HasColumnName(@"NM_GP_ETP").IsRequired().IsUnicode(false).HasColumnType("varchar").HasMaxLength(40);
			builder.Property(x => x.DescricaoGrupoEtapa).HasColumnName(@"DE_GP_ETP").IsRequired().IsUnicode(false).HasColumnType("varchar").HasMaxLength(300);

			base.Map(builder);
		}
	}
}
