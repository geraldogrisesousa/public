using AutoMapper;
using BA.Grisecorp.App.API.Application.ViewModels;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo;

namespace BA.Grisecorp.App.API.Application.AutoMapper
{
    public class ViewModelToDomainMappingProfile : Profile
    {
        public ViewModelToDomainMappingProfile()
        {
            CreateMap<EtapaModel, Etapa>();
            CreateMap<GrupoEtapaModel, GrupoEtapa>();
        }
    }
}
