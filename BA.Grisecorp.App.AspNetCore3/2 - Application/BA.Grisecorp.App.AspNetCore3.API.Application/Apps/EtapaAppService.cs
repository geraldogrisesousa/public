using AutoMapper;
using BA.Grisecorp.App.AspNetCore3.API.Application.Apps.Core;
using BA.Grisecorp.App.AspNetCore3.API.Application.Interfaces;
using BA.Grisecorp.App.AspNetCore3.API.Application.ViewModels;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa.Services;
using BA.Grisecorp.App.AspNetCore3.API.Domain.Notifications;
using MediatR;
using System;
using System.Collections.Generic;

namespace BA.Grisecorp.App.AspNetCore3.API.Application.Apps
{
    public class EtapaAppService : ApplicationService, IEtapaAppService
    {
        private readonly IMapper _mapper;

        private readonly IEtapaService _etapaService;

        public EtapaAppService(IMediator mediator,
                               INotificationHandler<DomainNotification> notifications,
                               IMapper mapper,
                               IEtapaService etapaService
                                       ) : base(mediator, notifications)
        {
            _mapper = mapper;
            _etapaService = etapaService;

        }

        void IEtapaAppService.InserirEtapa(EtapaModel etapa)
        {
            _etapaService.InserirEtapa(_mapper.Map<Etapa>(etapa));
        }

        void IEtapaAppService.AlterarEtapa(EtapaModel etapa)
        {
            _etapaService.AlterarEtapa(_mapper.Map<Etapa>(etapa));
        }

        void IEtapaAppService.DeletarEtapa(int id)
        {
            _etapaService.DeletarEtapa(id);
        }

        EtapaModel IEtapaAppService.ConsultarPorId(int id)
        {
            return _mapper.Map<EtapaModel>(_etapaService.ConsultarPorId(id));
        }

        List<EtapaModel> IEtapaAppService.ListaEtapas()
        {
            return _mapper.Map<List<EtapaModel>>(_etapaService.ListarEtapas());
        }

        List<EtapaModel> IEtapaAppService.ListaEtapaPorGrupo(int grupo)
        {
            return _mapper.Map<List<EtapaModel>>(_etapaService.ListarEtapasPorGrupo(grupo));
        }

        public void Dispose()
        {
            GC.SuppressFinalize(this);
            Dispose(true);
        }

        protected virtual void Dispose(bool disposing)
        {
            _etapaService.Dispose();
        }
    }
}
