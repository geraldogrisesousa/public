using BA.Grisecorp.App.API.Services.Filters;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Options;
using Swashbuckle.AspNetCore.Swagger;

namespace BA.Grisecorp.App.API.Services.Configuration
{
    public static class SwaggerConfiguration
    {    
        public static void AddSwaggerConfig(this IServiceCollection services, IConfiguration configuration)
        {
            var swaggerOptions = new SwaggerOptions();
            new ConfigureFromConfigurationOptions<SwaggerOptions>(configuration.GetSection("SwaggerOptions"))
                .Configure(swaggerOptions);

            services.AddSwaggerGen(s =>
            {
                s.SwaggerDoc(swaggerOptions.Version, new Info
                {
                    Version = swaggerOptions.Version,
                    Title = swaggerOptions.Title,
                    Description = swaggerOptions.Description,
                    Contact = new Contact { Name = "Grisecorp-S001" }
                });
                //s.OperationFilter<AuthorizationHeaderParameterOperationFilter>();
            });
        }
    }
}