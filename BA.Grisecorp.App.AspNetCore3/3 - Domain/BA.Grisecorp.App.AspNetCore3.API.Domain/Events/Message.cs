﻿using System;
using System.Collections.Generic;
using System.Text;

namespace BA.Grisecorp.App.AspNetCore3.API.Domain.Events
{
    public abstract class Message
    {
        public string MessageType { get; protected set; }
        public Guid AggregateId { get; protected set; }

        protected Message()
        {
            AggregateId = Guid.NewGuid();
            MessageType = GetType().Name;
        }
    }
}
