public class Principal {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.conectar();

        //inserir um elemento na tabela
        Usuario usuario = new Usuario (11, "pablo","pablo",'M');
        if(dao.inserirUsuario(usuario)==true) {
            System.out.println("Inserção com sucesso ->" + usuario.toString());
        }

        //mostrar usuários do sexo masculino
        System.out.println("==== Mostrar usuários do sexo masculino === ");
        Usuario[] usuarios = dao.getUsuariosMasculinos();
        for(int i=0;i<usuarios.length;i++) {
            System.out.println(usuarios[i].toString());
        }

        // Atualizar usuario
        usuario.setSenha("nova senha");
        dao.atualizarUsuario(usuario);

        System.out.println(" Mostrar usuarios ");
        usuarios = dao.getUsuarios();
        for(int i = 0; i < usuarios.length; i++) {
        System.out.println(usuarios[ i ].toString());
        }
        dao.excluirUsuario(usuario.getCodigo());
        usuarios = dao.getUsuarios();
        System.out.println("mostrar usuarios");
        for(int i = 0;i < usuarios.length;i++) {
        System.out.println(usuarios [ i ].toString());
        }
        dao.close();
        }
        }