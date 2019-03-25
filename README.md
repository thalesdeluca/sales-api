# Sales API
[![Build Status](https://travis-ci.org/thalesdeluca/sales-api.svg?branch=tests)](https://travis-ci.org/thalesdeluca/sales-api)
[![Coverage Status](https://coveralls.io/repos/github/thalesdeluca/sales-api/badge.svg?branch=tests)](https://coveralls.io/github/thalesdeluca/sales-api?branch=tests)
### Downloads
[API stable release](https://github.com/thalesdeluca/sales-api/releases/download/1.0/sales-api.jar)

### Branching
This project utilizes multiple branches to manage code, which are:
<table>
    <tr>
        <td><b>Branch</b></td>
        <td><b>Role</b></td>
    </tr>
    <tr>
        <td>master</td>
        <td>Stable code goes here</td>
    </tr>
     <tr>
        <td>develop</td>
        <td>In Development code/features goes here</td>
      </tr>
</table>

## Installation

#### Requirements
<ul>
  <li>Maven</li>
  <li>JDK 8</li>
  <li>An IDE of your preference</li>
</ul>

Clone the repository

```
git clone https://github.com/thalesdeluca/sales-api.git
```
<br/>
Open up your IDE and import the project as a Maven project.
<br/><br/>
Download Dependencies

## Documentation

#### Endpoints
Requests and responses will all be in JSON. The application will run at ``http://localhost:8080`` which the endpoints are:
<table>
  <tr>
    <td><b>Route</td>
    <td>Method</td>
    <td>Role</td>
    <td>Body/Params</b></td>
  </tr>
  
  <tr>
    <td>/sales</td>
    <td>GET</td>
    <td>Get all sales</td>
    <td>-</td>
  </tr>
  
  <tr>
    <td>/sales</td>
    <td>POST</td>
    <td>Creates a sale. <i>Requires <b>Body</b></i>*</td>
    <td>value: number, <br/><br/>sellerId: number</td>
  </tr>
  
  <tr>
    <td>/sellers</td>
    <td>GET</td>
    <td>Get all sellers.</td>
    <td>-</td>
  </tr>
  
  <tr>
    <td>/sellers</td>
    <td>POST</td>
    <td>Creates a seller. <i>Requires <b>Body</b></i>*</td>
    <td>name: string</td>
  </tr>
  
  <tr>
    <td>/sellers/avg</td>
    <td>GET</td>
    <td>Retrieves a list containing seller Name, Sales Total and Average sales per day.  <i>Requires <b>Params</b></i>*</td>
    <td>begin: long(date), <br/><br/>end: long(date)</td>
  </tr>
    
  
</table>
