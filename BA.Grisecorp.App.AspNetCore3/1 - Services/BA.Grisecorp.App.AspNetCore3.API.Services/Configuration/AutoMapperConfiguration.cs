using AutoMapper;
using BA.Grisecorp.App.AspNetCore3.API.Application.AutoMapper;
using Microsoft.Extensions.DependencyInjection;
using System;

namespace BA.Grisecorp.App.AspNetCore3.API.Services.Configuration
{
    public static class AutoMapperConfiguration
    {
        public static void AddAutoMapperSetup(this IServiceCollection services)
        {
            if (services == null)
                throw new ArgumentNullException(nameof(services));

            services.AddAutoMapper(AppDomain.CurrentDomain.GetAssemblies());
            AutoMapperConfig.RegisterMappings();
        }
    }
}
