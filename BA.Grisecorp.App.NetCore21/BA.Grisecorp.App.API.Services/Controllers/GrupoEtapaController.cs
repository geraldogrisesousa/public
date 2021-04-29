//-------------------------------------------------------------------------------------			
// <copyright file="ProjetoController.cs" company="BNB">
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
    public class GrupoEtapaController : BaseController
    {
        private readonly IGrupoEtapaAppService _grupoEtapaAppService;

 

        public GrupoEtapaController(INotificationHandler<DomainNotification> notifications,
                                               IMediator mediator,
                                               IGrupoEtapaAppService grupoEtapaAppService) : base(notifications, mediator)
        {
            _grupoEtapaAppService = grupoEtapaAppService;
        }

      

        [HttpPost]
        [Route("ListarGrupoEtapas")]
        public IActionResult ListarGrupoEtapa()
        {
            try
            {
                return Response(_grupoEtapaAppService.ListaGrupoEtapa());
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }

        [HttpPost]
        [Route("InserirGrupoEtapa")]
        public IActionResult InserirGrupoEtapa([FromBody] GrupoEtapaModel model)
        {
            try
            {
                if (model == null)
                {
                    RaiseError("Existem um ou mais dados fora do formato requerido!");
                }

                return Response(_grupoEtapaAppService.InserirGrupoEtapa(model));
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
        [Route("AlterarGrupoEtapa")]
        public IActionResult AlterarGrupoEtapa([FromBody] GrupoEtapaModel grupo)
        {
            try
            {
                if (grupo == null)
                {
                    RaiseError("Existem um ou mais dados fora do formato requerido!");
                }

                _grupoEtapaAppService.AlterarGrupoEtapa(grupo);
                return Response();
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }


        [HttpPost]
        [Route("DeletarGrupoEtapa")]
        public IActionResult DeletarGrupoEtapa([FromBody] int id)
        {
            try
            {
                _grupoEtapaAppService.DeletarGrupoEtapa(id);
                return Response();
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }

        [HttpGet]
        [Route("DetalharGrupoEtapa")]
        public IActionResult Detalhar(int id)
        {
            try
            {
                return Response(_grupoEtapaAppService.ConsultarPorId(id));
            }
            catch (Exception ex)
            {
                RaiseError(ex.Message);
                return Response(null, ex.Message, null);
            }
        }
    }
}
