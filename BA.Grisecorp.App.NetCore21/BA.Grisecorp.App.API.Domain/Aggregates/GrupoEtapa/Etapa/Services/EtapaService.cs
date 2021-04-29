using MediatR;
using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;
using BA.Grisecorp.App.API.Domain.Services;
using BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa.Repository;

namespace BA.Grisecorp.App.API.Domain.Aggregates.GrupoEtapa.Etapa.Services
{

    public class EtapaService : Service, IEtapaService
    {

        private readonly IEtapaRepository _etapaRepository;

        public EtapaService(IMediator mediator,
                              IEtapaRepository etapaRepository
                              ) : base(mediator)
        {
            _etapaRepository = etapaRepository;
        }

        public void InserirEtapa(Etapa etapa)
        {
            etapa.IsValid();
            if (!IsValida(etapa))
            {
                RaiseError("Existe uma ou mais Etapas na mesma posição!");
            }
            else
            {
                _etapaRepository.Add(etapa);
                _etapaRepository.SaveChanges();
            }
           
        }

        public void AlterarEtapa(Etapa etapa)
        {
            etapa.IsValid();
            if (!IsValida(etapa))
            {
                RaiseError("Existe uma ou mais Etapas na mesma posição!");
            }
            else {
                _etapaRepository.Update(etapa);
                _etapaRepository.SaveChanges();
            }
           

        }

        private bool IsValida(Etapa etapa) {
            bool valida = true;
            int count = ListarEtapasPorGrupo(etapa.CodigoGrupoEtapa).Where(x => x.NumeroPosicao == etapa.NumeroPosicao && etapa.Sequencial != x.Sequencial).ToList().Count;
            if (count > 0)
            {
                valida = false;
            }
            return valida;
        }

        public void DeletarEtapa(int id)
        {
            _etapaRepository.Remove(ConsultarPorId(id));
            _etapaRepository.SaveChanges();
        }

        public Etapa ConsultarPorId(int id)
        {
            return _etapaRepository.Find(x => x.Sequencial == id).FirstOrDefault();
        }

        public List<Etapa> ListarEtapas()
        {
            return _etapaRepository.GetAll().ToList();
        }

        public List<Etapa> ListarEtapasPorGrupo(int codigoGrupo)
        {
            return _etapaRepository.ListarEtapasPorGrupo(codigoGrupo).ToList();
        }

        public void Dispose()
        {
            GC.SuppressFinalize(this);
            Dispose(true);
        }

        protected virtual void Dispose(bool disposing)
        {
            _etapaRepository.Dispose();
        }
    }
}

