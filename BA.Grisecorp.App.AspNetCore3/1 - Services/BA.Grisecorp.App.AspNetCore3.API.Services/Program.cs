using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;

namespace BA.Grisecorp.App.AspNetCore3.API.Services
{
    public class Program
    {
        public static void Main(string[] args)
        {
            CreateWebHostBuilder(args).Build().Run();
        }

        public static IWebHostBuilder CreateWebHostBuilder(string[] args) =>
           WebHost.CreateDefaultBuilder(args)
               .UseStartup<Startup>();
    }
}
