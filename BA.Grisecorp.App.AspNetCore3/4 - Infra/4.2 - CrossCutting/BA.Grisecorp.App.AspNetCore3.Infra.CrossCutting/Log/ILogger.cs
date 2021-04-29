using System;

namespace BA.Grisecorp.App.AspNetCore3.Infra.CrossCutting.Log
{
    public interface ILogger
    {
        void writeLog(Exception excecao);
    }
}
