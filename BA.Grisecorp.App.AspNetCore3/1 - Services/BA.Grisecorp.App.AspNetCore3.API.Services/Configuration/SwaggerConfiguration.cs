using BA.Grisecorp.App.AspNetCore3.API.Services.Filters;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Options;
using Microsoft.OpenApi.Models;
using Swashbuckle.AspNetCore.Swagger;
using System;

namespace BA.Grisecorp.App.AspNetCore3.API.Services.Configuration
{
    public static class SwaggerConfiguration
    {    
        public static void AddSwaggerConfig(this IServiceCollection services, IConfiguration configuration)
        {
            var swaggerOptions = new SwaggerOptions();
            new ConfigureFromConfigurationOptions<SwaggerOptions>(configuration.GetSection("SwaggerOptions"))
                .Configure(swaggerOptions);

            services.AddSwaggerGen(c => {

                c.SwaggerDoc("v1",
                    new OpenApiInfo
                    {
                        Title = "Grisecorp Asp.Net Core 3.1",
                        Version = "v1",
                        Description = "Aplicação Grisecorp",
                        Contact = new OpenApiContact
                        {
                            Name = "Renato Groffe",
                            Url = new Uri("http://grisrcorp.com")
                        }
                    });
            });

        }
    }
}