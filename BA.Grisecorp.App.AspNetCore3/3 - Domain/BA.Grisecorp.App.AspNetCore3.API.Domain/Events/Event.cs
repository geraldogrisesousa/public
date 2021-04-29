using MediatR;
using System;


namespace BA.Grisecorp.App.AspNetCore3.API.Domain.Events
{
    public abstract class Event : Message, INotification
    {
        public DateTime Timestamp { get; private set; }

        protected Event()
        {
            Timestamp = DateTime.Now;
        }
    }
}
