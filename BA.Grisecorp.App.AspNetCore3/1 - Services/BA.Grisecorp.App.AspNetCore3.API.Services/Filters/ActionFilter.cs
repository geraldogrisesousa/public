using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.Model;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;

namespace BA.Grisecorp.App.API.Services.Filters
{
    public class ActionFilter : IActionFilter
    {
        private readonly Token _token;
        private readonly ILogger _logger;

        /// <summary>
        /// Propriedade para carregamentos dos parametros.
        /// </summary>
        public string Parametros { get; set; }

        public ActionFilter(Token token, ILogger<ActionFilter> logger)
        {
            _token = token;
            _logger = logger;
        }

        public void OnActionExecuted(ActionExecutedContext context)
        {
            if (context.Exception != null)
            {
                _logger.LogError(context.Exception, "Ocorreu um erro. Parâmetros de entrada: {Parametros}", Parametros);
            }
        }

        public void OnActionExecuting(ActionExecutingContext context)
        {
            Parametros = JsonConvert.SerializeObject(context.ActionArguments);
        }
    }
}
