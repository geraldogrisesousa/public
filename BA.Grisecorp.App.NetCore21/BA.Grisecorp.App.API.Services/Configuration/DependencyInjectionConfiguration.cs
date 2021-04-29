using MediatR;
using Microsoft.Extensions.DependencyInjection;
using BA.Grisecorp.App.API.Services.Middlewares;
using BA.Grisecorp.App.CrossCutting.IoC;

namespace BA.Grisecorp.App.API.Services.Configuration
{
    public static class DependencyInjectionConfiguration
    {
        public static void AddDIConfiguration(this IServiceCollection services)
        {
            BootStrapper.RegisterServices(services);           

            services.AddScoped(typeof(IPipelineBehavior<,>), typeof(MediatorMiddleware<,>));
        }
    }
}
