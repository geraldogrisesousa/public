using BA.Grisecorp.App.AspNetCore3.API.Application.Apps;
using BA.Grisecorp.App.AspNetCore3.API.Application.Interfaces;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa.Repository;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa.Services;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo.Repository;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo.Services;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Notifications;
using BA.Grisecorp.App.AspNetCore3.Infra.CrossCutting.Log;
using BA.Grisecorp.App.AspNetCore3.Infra.Data.Context;
using BA.Grisecorp.App.AspNetCore3.Infra.Data.Repository;
using BA.Grisecorp.App.Infra.Data.Repository;
using MediatR;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.AspNetCore3.Infra.CrossCutting.IoC
{
    public static class BootStrapper
    {
        public static void RegisterServices(IServiceCollection services)
        {
            // Application
            services.AddScoped<IEtapaAppService, EtapaAppService>();
            services.AddScoped<IGrupoEtapaAppService, GrupoEtapaAppService>();

            // Integração
            // services.AddScoped<ColaboradorIntegracaoService, ColaboradorIntegracaoService>();

            // Domain
            services.AddScoped<INotificationHandler<DomainNotification>, DomainNotificationHandler>();

            // Service
            services.AddSingleton<ILogger, Logger>();
            services.AddScoped<IEtapaService, EtapaService>();
            services.AddScoped<IGrupoEtapaService, GrupoEtapaService>();

            // Data
            services.AddScoped<DatabaseContext>();
            services.AddScoped<IEtapaRepository, EtapaRepository>();
            services.AddScoped<IGrupoEtapaRepository, GrupoEtapaRepository>();
        }
    }
}
