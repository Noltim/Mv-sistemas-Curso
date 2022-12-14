import axios, { Axios } from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewObraInspecao() {
  const [obrasInspencao, setObrasInspencao] = useState([]);

  useEffect(() => {
    loadObras();
  }, []);

  const {id} = useParams();

  let token = localStorage.getItem("user")
  
  const loadObras = async () => {
    const result = await axios.get(`http://localhost:8080/api/obrainspecoes`, { headers: { "Authorization": token } })
    console.log(result.data);
    setObrasInspencao(result.data);
  };

  const deleteObras = async (id) => {
    await axios.delete(`http://localhost:8080/api/obrainspecoes/${id}`, { headers: { "Authorization": token } })
    loadObras();
  }

  return (
    <div className='conteiner text-light'>

      <div className='p-5'>
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">obra</th>
              <th scope="col">frequencia</th>
              <th scope="col">mes</th>
              <th scope="col">status</th>
              <th scope="col">prioridade</th>
              <th scope="col">Ação</th>
            </tr>
          </thead>
          <tbody>
          {
              obrasInspencao.map(( obra, index ) => (
              <tr>
                <th scope='row' key={index}>{index + 1}</th>
                <td>{obra.obraId.nome}</td>
                <td>{obra.frequencia}</td>
                <td>{obra.mes}</td>
                <td>{obra.status}</td>
                <td>{obra.prioridade}</td>
                <td>
                  <Link 
                  to={`/viewobrainspecaoid/${obra.id}`} className='btn btn-primary mx-2'>View</Link>
                  <Link 
                  to={`/editobrainspecao/${obra.id}`}
                  className='btn btn-outline-primary mx-2'>Editar
                  </Link>
                  <button className='btn btn-danger mx-2'
                    onClick={()=>deleteObras(obra.id)}
                  >Deletar</button>
                </td>
              </tr>
              ))
            }
            
          </tbody>
        </table>
      </div>
    </div>
  )
}