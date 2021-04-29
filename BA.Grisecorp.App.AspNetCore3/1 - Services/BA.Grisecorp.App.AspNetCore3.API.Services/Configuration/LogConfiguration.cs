using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Options;
using System;
using BA.Grisecorp.App.AspNetCore3.Infra.CrossCutting.Log;

namespace BA.Grisecorp.App.AspNetCore3.API.Services.Configuration
{
    public static class LogConfiguration
    {
        public static void AddLoggerService(this IServiceCollection services, IConfiguration configuration)
        {
            if (services == null) throw new ArgumentNullException(nameof(services));

            var LoggerOptions = new LoggerOptions();
            new ConfigureFromConfigurationOptions<LoggerOptions>(configuration.GetSection("LogOptions"))
                .Configure(LoggerOptions);

            services.AddSingleton(LoggerOptions);
        }
    }
}