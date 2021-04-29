using System;
using System.Globalization;

namespace BA.Grisecorp.App.AspNetCore3.API.Application.ViewModels
{
    public class EtapaModel
    {
        public int Sequencial { get; set; }

        public int CodigoGrupoEtapa { get; set; }

        public string Descricao { get; set; }

        public string Nome { get; set; }

        public int NumeroPosicao { get; set; }

        public int? QuantidadeEntrega { get; set; }

        public int DuracaoEntregaMeses { get; set; }

        public DateTime DataCadastro { get; set; }

        public string DataFormatada
        {
            get => DataCadastro.ToString("dd/MM/yyyy", CultureInfo.CreateSpecificCulture("pt-BR"));
        }

        public string UsuarioCadastro { get; set; }
    }
}
