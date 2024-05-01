<h1>API de League of Legends com Integração IA do Google Gemini</h1>

<p>Este projeto é uma API desenvolvida em Spring Boot que fornece informações sobre os campeões do League of Legends, conectada a um banco de dados H2 embutido. Além disso, integra a inteligência artificial do Google Gemini, permitindo que os usuários façam perguntas sobre os campeões selecionados e recebam respostas simuladas baseadas nas lore dos personagens.</p>

<h2>Funcionalidades Principais:</h2>

<ul>
  <li><strong>Consulta de Campeões:</strong> Os usuários podem obter informações detalhadas sobre todos os 160 campeões disponíveis no League of Legends, incluindo nome, função, lore e imagem.</li>
  <li><strong>Integração com IA do Google Gemini:</strong> Utilizando a API do Google Gemini, os usuários podem fazer perguntas específicas sobre um campeão selecionado por meio de um ID e receber respostas simuladas baseadas na lore do personagem.</li>
  <li><strong>Armazenamento em Banco de Dados H2:</strong> Todos os dados dos campeões são armazenados em um banco de dados H2 embutido, permitindo uma consulta eficiente e rápida.</li>
</ul>

<h2>Como Usar:</h2>

<ol>
  <li><strong>Clone o Repositório:</strong> Clone este repositório para o seu ambiente local.</li>
  <li><strong>Execute a Aplicação:</strong> Execute a aplicação Spring Boot.</li>
  <li><strong>Acesse a API:</strong> Acesse a API através do navegador ou utilizando ferramentas como Postman.</li>
  <li><strong>Consulte os Campeões:</strong> Utilize as rotas disponíveis para obter informações sobre os campeões e faça perguntas utilizando a integração com a IA do Google Gemini.</li>
</ol>

<h2>Exemplo de Uso:</h2>

<pre>
  <code>GET /api/champions</code>
</pre>

<pre>
  <code>GET /api/champions/{id}</code>
</pre>

<pre>
  <code>GET /api/champions/{id}/ask?question={pergunta}</code>
</pre>

<h2>Tecnologias Utilizadas:</h2>

<ul>
  <li>Spring Boot</li>
  <li>H2 Database</li>
  <li>Google Gemini API</li>
  <li>Java</li>
</ul>
