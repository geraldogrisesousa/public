//-------------------------------------------------------------------------------------			
// <copyright file="ProjetoController.cs" company="Grisecorp">
//    Copyright statement. All right reserved
// </copyright>	
// <summary>
//   Classe de serviço AnexosService
// </summary>		
//-------------------------------------------------------------------------------------

namespace BA.Grisecorp.App.API.Services.Controllers
{
    using BA.Grisecorp.App.API.Application.Interfaces;
    using BA.Grisecorp.App.API.Application.ViewModels;
    using BA.Grisecorp.App.API.Domain.Exceptions;
    using BA.Grisecorp.App.API.Domain.Notifications;
    using BA.Grisecorp.App.API.Services.Controllers.Core;
    using MediatR;
    using Microsoft.AspNetCore.Mvc;
    using System;

    /// <summary>
    /// Claase para controller da API
    /// </summary>
    [Route("api")]
    public class EtapaController : BaseController
    {
        private readonly IEtapaAppService _etapaAppService;

        public EtapaController(INotificationHandler<DomainNotification> notifications,
                                               IMediator mediator,
                                               IEtapaAppService etapaAppService) : base(notifications, mediator)
        {
            _etapaAppService = etapaAppService;
        }

        [HttpPost]
        [Route("ListarEtapasPorGrupo")]
        public IActionResult ListarEtapasPorGrupo([FromBody] int codigo)
        {
            try
            {
                return Response(_etapaAppService.ListaEtapaPorGrupo(codigo));
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }

        [HttpPost]
        [Route("ListarEtapas")]
        public IActionResult ListarEtapas()
        {
            try
            {
                return Response(_etapaAppService.ListaEtapas());
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }

        [HttpPost]
        [Route("InserirEtapa")]
        public IActionResult InserirEtapa([FromBody] EtapaModel etapa)
        {
            try
            {
                if (etapa == null)
                {
                    RaiseError("Existem um ou mais dados fora do formato requerido!");
                }
                _etapaAppService.InserirEtapa(etapa);
                return Response();
            }
            catch (ValidacaoException ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null, "warning");
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }

        [HttpPost]
        [Route("AlterarEtapa")]
        public IActionResult AlterarEtapa([FromBody] EtapaModel etapa)
        {
            try
            {
                if (etapa == null)
                {
                    RaiseError("Existem um ou mais dados fora do formato requerido!");
                }
                _etapaAppService.AlterarEtapa(etapa);
                return Response();
            }
            catch (ValidacaoException ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null, "warning");
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        } 
        
        [HttpPost]
        [Route("DeletarEtapa")]
        public IActionResult DeletarEtapa([FromBody] int id)
        {
            try
            {
                _etapaAppService.DeletarEtapa(id);
                return Response();
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }

        [HttpGet]
        [Route("DetalharEtapa")]
        public IActionResult DetalharEtapa(int id)
        {
            try
            {
                return Response(_etapaAppService.ConsultarPorId(id));
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }

    }
}
