# Spring Security

## Spring Security általános bemutatása

Viczián István
istvan.viczian@training360.com

* Authentication and access-control framework
* Protection Against Exploits
    * CSRF
    * HTTP Headers
* Acegi
* Authentication and authorization
* WebMVC és WebFlux integráció
* Websocket támogatás
* [Spring Data JPA integráció](https://docs.spring.io/spring-security/reference/features/integrations/data.html#data-query)
* ApplicationContext eventeket dobál, pl. bejelentkezéskor, authorizációkor

## Használati esetek

* Webes alkalmazást szeretnék írni, saját autentikációval, pl. felhasználónév és jelszó párral
    * Felhasználónév és jelszó megadása formon (vagy Basic, Digest)
    * A felhasználókat saját adatbázisból szeretném betölteni
    * A felhasználókat LDAP-ból, vagy Active Directory-ból szeretném betölteni
* Webes alkalmazást szeretnék írni, de továbbítom a környezetnek a feladatokat
    * Pl. az alkalmazásszervernek JAAS esetén
* Webes alkalmazást vagy REST API-t írok, és SSL certificate-tel (X.509) szeretnék authentikálni
* Web alkalmazást, API Gateway-t vagy BFF-et írok, és OAuth 2.0 / OIDC-t szeretnék használni
* REST API-t implementálok és OAuth 2.0 Opaque Tokent vagy JWT tokent szeretnék használni
* SAML 2.0 Logint szeretnék
* CAS-sal (Central Authentication Server) szeretnék bejelentkezni
* Gányolni szeretnék valami saját megoldást

## Architektúra

* Servlet környezetben Servlet Filterekre támaszkodik
* Servlet környezetbe illeszkedő, de Spring beanekkel kommunikáló filter: DelegatingFilterProxy
* Spring Security támogatás FilterChainProxy, mely a SecurityFilterChain-be hív be
* SecurityFilterChain-ben Security Filterek
    * https://docs.spring.io/spring-security/reference/servlet/architecture.html#servlet-securityfilterchain
* Mapping alapján különböző chainek

## Autentikáció

* Saját perzisztens réteg írható
* Sessionbe tárolja az adatokat
    * Vagy a kliensnek mindig küldenie kell
    * Vagy clusterezés esetén külső tárban, pl. cache, adatbázis
* Remember Me
* Anonymous
* Pre-Authentication
    * X.509
    * JAAS

## Authorizáció

* HTTP URL alapján
* Method security (deklaratív)
* Kódból lekérdezhető
* View rétegben JSP taglib, vagy Thymeleaf security névtér
* ACL
    * https://www.jtechlog.hu/2010/07/11/spring-security-3-acl.html


## Webes alkalmazást szeretnék írni, saját autentikációval, pl. felhasználónév és jelszó párral

Változások:

* `WebSecurityConfigurerAdapter` leváltása
* Lambda DSL
    * Nincs benne `and()`
* https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

* Auto Configuration
    * https://docs.spring.io/spring-security/reference/servlet/getting-started.html#servlet-hello-auto-configuration

https://www.jtechlog.hu/2023/03/28/spring-security-spring-boot.html

# OAuth 2.0

* OAuth 2.0: authorization delegation framework
* OIDC - OpenID Connect: add-on, client app. identity verification
* Fogalmak:
    * Resource owner: felhasználó
    * Client: Webapp, mobile app
    * Resource server: védett API
    * Auth server: bejelentkeztetést végez
* Grant flow:
    * Authorization code grant flow - legbiztonságosabb, de legkomplexebb
    * Implicit grant: SPA-k esetén, nincs client secret
        * Deprecated
        * Helyette:  Proof Key for Code Exchange (PKCE)
    * Resource owner password credentials
        * Deprecated
    * Client credentials
        * Server-server kommunikáció
        * Jó tesztelésre is
* Fogalmak még:
    * Client id, client secret
    * Redirect URI
    * Authorization code
    * Access token
    * Refresh token: client kér új tokent
    * Scope
    * Consent
* OIDC
    * Extra token: ID token
    * JWT
    * Claim
    * Opcionális: Access token is JWT token
    * Discovery endpoint: code, token, signature endpoint
    
## Scopes

* Scopes vs roles

## KeyCloak

* Spring Security OAuth deprecated!
* Keycloak adapter deprecated!
    * https://www.keycloak.org/2022/02/adapter-deprecation

https://www.jtechlog.hu/2020/02/19/spring-oauth2.html

## Kliens

* `spring-boot-starter-oauth2-client` függőség

## Resource server

* `spring-boot-starter-oauth2-resource-server` függőség

## Spring Authorization Server

* `spring-boot-starter-oauth2-authorization-server` függőség

# JWT

https://www.jtechlog.hu/2019/03/18/jwt-es-spring-security.html

