namespace BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Etapa
{
    using System.Collections.Generic;
    using System.Text;
    using System;
    using System.ComponentModel.DataAnnotations;
    using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.Model;
    using BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.GrupoEtapa.Grupo;
    using BA.Grisecorp.App.AspNetCore3.API.Domain.Exceptions;

    /// <summary>
    /// Classe de Etapa
    /// </summary>
    public class Etapa : EntityCore<Etapa>
    {
        public virtual int Sequencial { get; protected set; }

        [Range(1, int.MaxValue, ErrorMessage = "O campo Grupo etapa é obrigatório.")]
        [Required(ErrorMessage = "O campo Grupo etapa  é obrigatório.")]
        public virtual int CodigoGrupoEtapa { get; protected set; }

        public virtual GrupoEtapa GrupoEtapa { get; protected set; }

        [Required(ErrorMessage = "O campo Nome é obrigatório.")]
        public virtual string Nome { get; protected set; }

        [Required(ErrorMessage = "O campo Descrição é obrigatório.")]
        public virtual string Descricao { get; protected set; }


        [Range(1, int.MaxValue, ErrorMessage = "O campo Posição é obrigatório.")]
        [Required(ErrorMessage = "O campo Posição é obrigatório.")]
        public virtual int NumeroPosicao { get; protected set; }

        public virtual int? QuantidadeEntrega { get; protected set; }

        [Range(1, int.MaxValue, ErrorMessage = "O campo Quantidade de entregas é obrigatório.")]
        [Required(ErrorMessage = "O campo Quantidade de entregas é obrigatório.")]
        public virtual int DuracaoEntregaMeses { get; protected set; }

        public virtual DateTime DataCadastro { get; protected set; }

        public virtual string UsuarioCadastro { get; protected set; }

        #region Validações

        public override bool IsValid()
        {
            ValidationResult = Validate(this);

            if (!ValidationResult.IsValid)
            {
                return ValidationResult.IsValid;
            }

            var resultadoValidacao = new List<ValidationResult>();
            var contexto = new ValidationContext(this, null, null);
            Validator.TryValidateObject(this, contexto, resultadoValidacao, true);

            if (resultadoValidacao.Count > 0)
            {
                StringBuilder msgs = new StringBuilder();
                foreach (var validacao in resultadoValidacao)
                {
                    msgs.Append(validacao.ToString() + "<br/>");
                }
                throw new ValidacaoException(msgs.ToString());
            }

            return true;
        }

        #endregion
    }
}
