﻿using BA.Grisecorp.App.API.Domain.Aggregates;
using BA.Grisecorp.App.API.Domain.Aggregates.Model;
using System;
using System.Collections.Generic;
using System.Linq.Expressions;

namespace BA.Grisecorp.App.API.Domain.Interfaces
{
    public interface IRepository<TEntity> : IDisposable where TEntity : EntityCore<TEntity>
    {
        void Add(TEntity entity);

        void Add(IEnumerable<TEntity> entity);

        TEntity GetById(params object[] ids);

        IEnumerable<TEntity> GetAll();

        void Update(TEntity entity);

        void Update(IEnumerable<TEntity> entity);

        void Update(TEntity current, TEntity updated);

        void Remove(params object[] ids);

        void Remove(TEntity entity);

        void Remove(IEnumerable<TEntity> entity);

        IEnumerable<TEntity> Find(Expression<Func<TEntity, bool>> predicate);

        int SaveChanges();
    }
}
