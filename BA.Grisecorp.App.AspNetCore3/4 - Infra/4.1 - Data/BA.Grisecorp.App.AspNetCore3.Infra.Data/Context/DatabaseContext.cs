using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo;
using BA.Grisecorp.App.AspNetCore3.Infra.Data.Core.Extensions;
using BA.Grisecorp.App.AspNetCore3.Infra.Data.Mappings;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using System.IO;


namespace BA.Grisecorp.App.AspNetCore3.Infra.Data.Context
{
    public class DatabaseContext : DbContext
    {
        public DbSet<Etapa> Etapas { get; set; }
        public DbSet<GrupoEtapa> GrupoEtapas { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.AddConfiguration(new EtapaMap());
            modelBuilder.AddConfiguration(new GrupoEtapaMap());
            base.OnModelCreating(modelBuilder);
        }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            var config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json")
                .Build();

            optionsBuilder.EnableSensitiveDataLogging(false);
            optionsBuilder.UseSqlServer(config.GetConnectionString("DefaultConnection"), opt => opt.CommandTimeout(120));
        }
    }
}
