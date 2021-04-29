
namespace BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo
{

    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.Text;
    using BA.Grisecorp.App.API.Domain.Aggregates.Model;
    using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa;
    using BA.Grisecorp.App.API.Domain.Exceptions;

    public class GrupoEtapa : EntityCore<GrupoEtapa>
    {
        public virtual int Sequencial { get; protected set; }


        public virtual List<Etapa> ListaEtapa { get; protected set; }

        [Required(ErrorMessage ="O campo de Nome do Grupo Etapa é obrigatório.")]
        public virtual string NomeGrupoEtapa { get; set; }

        [Required(ErrorMessage = "O campo de Descrição do Grupo Etapa é obrigatório.")]
        public virtual string DescricaoGrupoEtapa { get; protected set; }

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
