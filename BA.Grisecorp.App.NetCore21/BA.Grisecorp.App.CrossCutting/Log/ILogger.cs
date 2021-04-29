using System;

namespace BA.Grisecorp.App.CrossCutting.Log
{
    public interface ILogger
    {
        void writeLog(Exception excecao);
    }
}
