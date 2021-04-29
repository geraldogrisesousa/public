using MediatR;
using System;
using System.Collections.Generic;
using System.Linq;
using BA.Grisecorp.App.API.Domain.Services;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo.Repository;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa.Repository;

namespace BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Grupo.Services
{

    public class GrupoEtapaService : Service, IGrupoEtapaService
    {

        private readonly IGrupoEtapaRepository _grupoEtapaRepository;
        private readonly IEtapaRepository _etapaRepository;

        public GrupoEtapaService(IMediator mediator,
                              IGrupoEtapaRepository grupoEtapaRepository,
                              IEtapaRepository etapaRepository
                              ) : base(mediator)
        {
            _grupoEtapaRepository = grupoEtapaRepository;
            _etapaRepository = etapaRepository;
        }

        public int InserirGrupoEtapa(GrupoEtapa grupo)
        {
            grupo.IsValid();
            _grupoEtapaRepository.Add(grupo);
            _grupoEtapaRepository.SaveChanges();
            return grupo.Sequencial;
        }
        public void AlterarGrupoEtapa(GrupoEtapa grupo)
        {
            grupo.IsValid();
            _grupoEtapaRepository.Update(grupo);
            _grupoEtapaRepository.SaveChanges();
        }

        public void DeletarGrupoEtapa(int id)
        {
            RemoverEtapasAssociadas(id);
            _grupoEtapaRepository.Remove(ConsultarPorId(id));
            _grupoEtapaRepository.SaveChanges();


        }

      
        private void RemoverEtapasAssociadas(int codigoGrupo)
        {
            _etapaRepository.Remove(_etapaRepository.ListarEtapasPorGrupo(codigoGrupo));
            _etapaRepository.SaveChanges();
        }

        public GrupoEtapa ConsultarPorId(int id)
        {
            return _grupoEtapaRepository.Find(x => x.Sequencial == id).FirstOrDefault();
        }
        public List<GrupoEtapa> ListarGrupoEtapa()
        {
            return _grupoEtapaRepository.GetAll().ToList();
        }

        public void Dispose()
        {
            GC.SuppressFinalize(this);
            Dispose(true);
        }


        protected virtual void Dispose(bool disposing)
        {
            _etapaRepository.Dispose();
            _grupoEtapaRepository.Dispose();
        }
    }
}

