using AutoMapper;
using BA.Grisecorp.App.AspNetCore3.API.Application.ViewModels;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.AspNetCore3.API.Application.AutoMapper
{
    public class DomainToViewModelMappingProfile : Profile
    {
        public DomainToViewModelMappingProfile()
        {
            CreateMap<Etapa, EtapaModel>();
            CreateMap<GrupoEtapa, GrupoEtapaModel>();
        }
    }
}
