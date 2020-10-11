/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.ifel.directoryserver.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Daniel Filho
 */

@Entity
@Table(name = "tbl_KeyPaths", catalog = "FiveDS", schema = "dbo")
@Data
@NoArgsConstructor
public class KeyPaths implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "key_id")
    private String keyId;
    @Basic(optional = false)
    @Column(name = "full_path")
    private String fullPath;
    @Basic(optional = false)
    @Column(name = "depth")
    private short depth;
    @JoinColumn(name = "key_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Keys keys;
    
}
