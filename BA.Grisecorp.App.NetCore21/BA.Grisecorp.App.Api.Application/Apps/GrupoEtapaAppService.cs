using AutoMapper;
using BA.Grisecorp.App.API.Application.Apps.Core;
using BA.Grisecorp.App.API.Application.Interfaces;
using BA.Grisecorp.App.API.Application.ViewModels;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo.Services;
using BA.Grisecorp.App.API.Domain.Notifications;
using MediatR;
using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.API.Application.Apps
{
    public class GrupoEtapaAppService : ApplicationService, IGrupoEtapaAppService
    {
        private readonly IMapper _mapper;

        private readonly IGrupoEtapaService _grupoEtapaService;

        public GrupoEtapaAppService(IMediator mediator,
                                    INotificationHandler<DomainNotification> notifications,
                                    IMapper mapper,
                                    IGrupoEtapaService grupoEtapaService
                                       ) : base(mediator, notifications)
        {
            _mapper = mapper;
            _grupoEtapaService = grupoEtapaService;

        }

        int IGrupoEtapaAppService.InserirGrupoEtapa(GrupoEtapaModel grupo)
        {
            return _grupoEtapaService.InserirGrupoEtapa(_mapper.Map<GrupoEtapa>(grupo));
        }

        void IGrupoEtapaAppService.AlterarGrupoEtapa(GrupoEtapaModel grupo)
        {
            _grupoEtapaService.AlterarGrupoEtapa(_mapper.Map<GrupoEtapa>(grupo));
        }

        void IGrupoEtapaAppService.DeletarGrupoEtapa(int id)
        {
            _grupoEtapaService.DeletarGrupoEtapa(id);
        }

        GrupoEtapaModel IGrupoEtapaAppService.ConsultarPorId(int id)
        {
            return _mapper.Map<GrupoEtapaModel>(_grupoEtapaService.ConsultarPorId(id));
        }

        List<GrupoEtapaModel> IGrupoEtapaAppService.ListaGrupoEtapa()
        {
            return _mapper.Map<List<GrupoEtapaModel>>(_grupoEtapaService.ListarGrupoEtapa());
        }

        public void Dispose()
        {
            GC.SuppressFinalize(this);
            Dispose(true);
        }

        protected virtual void Dispose(bool disposing)
        {
            _grupoEtapaService.Dispose();
        }
    }
}
