using FluentValidation;
using FluentValidation.Results;


namespace BA.Grisecorp.App.AspNetCore3.API.Domain.Aggregates.Model
{
    public abstract class EntityCore<T> : AbstractValidator<T> where T : EntityCore<T>
    {
        public ValidationResult ValidationResult { get; protected set; }

        protected EntityCore()
        {
            ValidationResult = new ValidationResult();
        }

        public abstract bool IsValid();

        public void AddValidationResult(ValidationResult validationResult)
        {
            if (validationResult != null)
                foreach (var error in validationResult.Errors)
                    ValidationResult.Errors.Add(error);
        }
    }
}
